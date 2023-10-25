package com.yedam.app.board.mapper;

import java.util.List;

import com.yedam.app.board.service.BoardVO;

public interface BoardMapper {
	// 전체 목록 조회
	public List<BoardVO> selectBoardList();
	
	// 단건 조회 : 조건 - bno(게시글번호) 만약 pk가 두개면 xml에 조건 두개 적어줘야함
	public BoardVO selectBoard(BoardVO boardVO);
	
	// 등록 : 대상 - bno(selectkey), title, contents, writer, image
	public int insertBoard(BoardVO boardVO);
	
	// 수정 : 대상 - title, contents, writer, updatedate, image
	public int updateBoard(BoardVO boardVO);
	
	// 삭제 : 조건 - bno
	public int deleteBoard(int boardNo);
}
