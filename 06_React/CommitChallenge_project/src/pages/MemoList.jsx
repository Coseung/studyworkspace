import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useMemo } from '../components/MemoContext.jsx';
import { ROUTES } from '../routes/routesPath.js';
import {
  Container,
  Content,
  Header,
  Title,
  BackButton,
  MemoGrid,
  MemoCard,
  CardHeader,
  CardDate,
  CardActions,
  EditButton,
  DeleteButton,
  InfoSection,
  InfoItem,
  InfoIcon,
  InfoLabel,
  InfoValue,
  MemoContent,
  MemoText,
  EditForm,
  Textarea,
  EditActions,
  SaveButton,
  CancelButton,
  EmptyState,
  EmptyIcon,
  EmptyText,
} from './MemoList.styled';

const MemoList = () => {
  const navigate = useNavigate();
  const { memos, updateMemo, deleteMemo } = useMemo();
  const [editingId, setEditingId] = useState(null);
  const [editText, setEditText] = useState('');

  const handleBack = () => {
    navigate(ROUTES.HOME);
  };

  const handleEditStart = (memo) => {
    setEditingId(memo.id);
    setEditText(memo.memo);
  };

  const handleEditSave = (id) => {
    if (!editText.trim()) return;
    
    updateMemo(id, editText);
    setEditingId(null);
    setEditText('');
  };

  const handleEditCancel = () => {
    setEditingId(null);
    setEditText('');
  };

  const handleDelete = (id) => {
    if (window.confirm('메모를 삭제하시겠습니까?')) {
      deleteMemo(id);
    }
  };

  return (
    <Container>
      <Content>
        <Header>
          <Title>📋 메모 목록</Title>
          <BackButton onClick={handleBack}>← 뒤로가기</BackButton>
        </Header>

        {memos.length > 0 ? (
          <MemoGrid>
            {memos.map(memo => (
              <MemoCard key={memo.id}>
                <CardHeader>
                  <CardDate>
                    {new Date(memo.createdAt).toLocaleString('ko-KR')}
                  </CardDate>
                  {editingId !== memo.id && (
                    <CardActions>
                      <EditButton onClick={() => handleEditStart(memo)}>
                        수정
                      </EditButton>
                      <DeleteButton onClick={() => handleDelete(memo.id)}>
                        삭제
                      </DeleteButton>
                    </CardActions>
                  )}
                </CardHeader>

                <InfoSection>
                  <InfoItem>
                    <InfoIcon>🕒</InfoIcon>
                    <InfoLabel>커밋 시간:</InfoLabel>
                    <InfoValue>
                      {new Date(memo.date).toLocaleString('ko-KR')}
                    </InfoValue>
                  </InfoItem>
                  
                  <InfoItem>
                    <InfoIcon>📂</InfoIcon>
                    <InfoLabel>리포지토리:</InfoLabel>
                    <InfoValue>{memo.repoName}</InfoValue>
                  </InfoItem>
                  
                  <InfoItem>
                    <InfoIcon>🔀</InfoIcon>
                    <InfoLabel>브랜치:</InfoLabel>
                    <InfoValue>{memo.branch}</InfoValue>
                  </InfoItem>
                </InfoSection>

                {editingId === memo.id ? (
                  <EditForm>
                    <Textarea
                      value={editText}
                      onChange={(e) => setEditText(e.target.value)}
                      placeholder="메모를 입력하세요..."
                    />
                    <EditActions>
                      <SaveButton onClick={() => handleEditSave(memo.id)}>
                        저장
                      </SaveButton>
                      <CancelButton onClick={handleEditCancel}>
                        취소
                      </CancelButton>
                    </EditActions>
                  </EditForm>
                ) : (
                  <MemoContent>
                    <MemoText>{memo.memo}</MemoText>
                  </MemoContent>
                )}
              </MemoCard>
            ))}
          </MemoGrid>
        ) : (
          <EmptyState>
            <EmptyIcon>📝</EmptyIcon>
            <EmptyText>작성된 메모가 없습니다</EmptyText>
          </EmptyState>
        )}
      </Content>
    </Container>
  );
};

export default MemoList;