package com.yedam.app.board.web;

import java.lang.ProcessBuilder.Redirect;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	BoardService boardService;
	
	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String getBoardList(Model model) {
		List<BoardVO> list = boardService.getBoardList();
		model.addAttribute("boardList", list);
		System.out.println(list);
		return "board/boardList";
	}
	// 게시판 단건조회 : URI - boardInfo / PARAMETER - BoardVO / RETURN -board/boardInfo
	@GetMapping("boardInfo")
	public String getBoard(BoardVO boardVO, Model model) {
		BoardVO findVO = boardService.getBoard(boardVO);
		model.addAttribute("boardInfo", findVO);
		System.out.println(findVO);
		return "board/boardInfo";
		
	}
	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String insertBoardForm() {
		return "board/boardInsert";
	}
	// 등록 - 처리 :URI - boardInsert / PARAMETER - BoardVO / RETURN - 전체조회 다시호출
	@PostMapping("boardInsert")
	public String insertBoardProcess(BoardVO boardVO, RedirectAttributes ratt) {
		int bno = boardService.insertBoard(boardVO);
		
		String path = null;
		if(bno > -1) {
			path = "정상적으로 등록되었습니다. \n등록 정보: "+ bno;
 		}else {
 			path = "등록 실패. \n정보를 확인해주시기 바랍니다.\n등록요청 : "+ bno;
 		}
		System.out.println(path);
 		ratt.addFlashAttribute("result", path);
 		return "redirect:boardList";
	}
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(BoardVO boardVO) {
		return "board/boardUpdate";
	}
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO / RETURN - 수정결과 데이터 (Map)
 	@PostMapping("boardUpdate")
 	@ResponseBody
 	public Map<String, Object> boardUpdateProcess(BoardVO boardVO){
 		return boardService.updateBoard(boardVO);
 	}
	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer / RETURN - 전체조회 다시호출
 	@GetMapping("boardDelete")
 	public String boardDeleteProcess(@RequestParam Integer bno, RedirectAttributes ratt) {
 		int result = boardService.deleteBoard(bno);
 		String msg = null;
 		if(result > -1) {
 			msg = "정상적으로 삭제되었습니다. \n삭제대상 : "+ bno;
 		}else {
 			msg = "삭제 실패. \n정보를 확인해주시기 바랍니다.\n삭제요청 : "+ bno;
 		}
 		ratt.addFlashAttribute("result", msg);
 		return "redirect:boardList";
 	}
}
