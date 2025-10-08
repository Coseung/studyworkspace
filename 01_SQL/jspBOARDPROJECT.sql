select * from board;
select * from CATEGORY;
select * from Member;

SELECT BOARD_NO,
			   CATEGORY_NAME,
               BOARD_TITLE,
               BOARD_CONTENT,
               MEMBER_ID,
               TO_CHAR(CREATE_DATE, 'YYYY/MM/DD') AS "CREATE_DATE"
          FROM BOARD
          LEFT JOIN CATEGORY USING(CATEGORY_NO)
          JOIN MEMBER ON(BOARD_WRITER = MEMBER_NO)
         WHERE BOARD_NO = 3;
         
 SELECT BOARD_NO,
		                   CATEGORY_NAME,
		                   BOARD_TITLE,
		                   MEMBER_ID,
		                   COUNT,
		                   TO_CHAR(CREATE_DATE, 'YYYY/MM/DD') AS "CREATE_DATE"
		              FROM BOARD B
		              JOIN CATEGORY USING(CATEGORY_NO)
		              JOIN MEMBER M ON(BOARD_WRITER = MEMBER_NO)
		             WHERE B.STATUS = 'Y'
		               AND BOARD_TYPE = 1
		             ORDER BY CREATE_DATE DESC;        
         
         
INSERT INTO BOARD (
    BOARD_NO,
    BOARD_TYPE,
    CATEGORY_NO,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_WRITER,
    COUNT,
    CREATE_DATE,
    STATUS
) VALUES (
    SEQ_BNO.NEXTVAL,     -- 게시글 번호
    1,                   -- 일반 게시판
    10,                   -- CATEGORY_NO 예시
    '첫 번째 게시글입니다.',
    '안녕하세요. 첫 번째 게시글의 내용입니다. 테스트용 데이터입니다.',
    1,                 -- 작성자: MEMBER.USER_NO 예시
    1,                  -- 조회수
    SYSDATE,         -- 작성일 (3일 전)
    'Y'                -- 활성 상태
                -- 대표 이미지 없음
);
INSERT INTO BOARD (
    BOARD_NO,
    BOARD_TYPE,
    CATEGORY_NO,
    BOARD_TITLE,
    BOARD_CONTENT,
    BOARD_WRITER,
    COUNT,
    CREATE_DATE,
    STATUS
) VALUES (
    SEQ_BNO.NEXTVAL,
    1,
    20,
    'Oracle 게시판 테스트 두 번째 글',
    '이 글은 Oracle 환경에서 작성된 더미데이터 예시입니다.',
    1,
    5,
    SYSDATE - 1,
    'Y'
);