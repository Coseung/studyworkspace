import React, { useState, useEffect } from 'react';
import { useParams, useNavigate } from 'react-router-dom';
import { useGithub } from '../components/GithubContext.jsx';
import { useMemo } from '../components/MemoContext.jsx';
import { ROUTES } from '../routes/routesPath.js';
import { WiTime1,FaFolderOpen,FaCodeBranch,CiMemoPad, GiHighGrass, FaPenToSquare, BiSolidCommentDetail } from "../components/icons/icons.js";

import {
  Container,
  Content,
  Header,
  BackButton,
  Title,
  InfoBox,
  InfoItem,
  InfoLabel,
  MemoSection,
  SectionTitle,
  MemoForm,
  Textarea,
  AddButton,

} from './PushDetail.styled';

const PushDetail = () => {
  const {detailId} = useParams();
  const navigate = useNavigate();
  const {pushHistory} = useGithub();
  const {addMemo, updateMemo, deleteMemo,getMemosByPushId} = useMemo();

  const [pushData, setPushData] =useState(null);
  const [memoText, setMemoText] = useState('');
  const [memos, setMemos] = useState([]);
  
  useEffect(()=>{
    const push = pushHistory.find(p=>p.id === detailId);
    if (push){
      setPushData(push);
      setMemos(getMemosByPushId(detailId));
    }
  },[detailId,pushHistory]);


  useEffect(() => {
    setMemos(getMemosByPushId(detailId));
  }, [detailId]);


  const handleAddMemo = () => {
    if( !memoText.trim()) return;

    addMemo(detailId,pushData,memoText);
    setMemoText('');
    setMemos(getMemosByPushId(detailId));
    alert('메모가 저장되었습니다!');
    navigate(ROUTES.MEMOLIST);
  }

  const handleBack = () => {
    navigate(ROUTES.HOME);
  };


  if (!pushData) {
    return (
      <Container>
        <Content>
          <Header>
            <BackButton onClick={handleBack}>← 뒤로가기</BackButton>
            <Title>푸시 정보를 찾을 수 없습니다</Title>
          </Header>
        </Content>
      </Container>
    )
  }

  return (
    <Container>
      <Content>
        <Header>
          <BackButton onClick={handleBack}>← 뒤로가기</BackButton>
          <Title><BiSolidCommentDetail/> 푸시 상세 정보</Title>
          <InfoBox>
            <InfoItem>
              <InfoLabel><WiTime1 /> 시간:</InfoLabel>
              {new Date(pushData.created_at).toLocaleString('ko-KR')}
            </InfoItem>
            <InfoItem>
              <InfoLabel><FaFolderOpen/> 리포지토리:</InfoLabel>
              {pushData.repo.name}
            </InfoItem>
            <InfoItem>
              <InfoLabel><FaCodeBranch/> 브랜치:</InfoLabel>
              {pushData.payload.ref ? pushData.payload.ref.replace('refs/heads/', '') : 'main'}
            </InfoItem>
          </InfoBox>
        </Header>

        <MemoSection>
          <SectionTitle><FaPenToSquare/> 메모 작성</SectionTitle>
          <MemoForm>
            <Textarea
              value={memoText}
              onChange={(e) => setMemoText(e.target.value)}
              placeholder="이 푸시에 대한 메모를 작성하세요..."
            />
            <AddButton onClick={handleAddMemo} disabled={!memoText.trim()}>
              메모 추가
            </AddButton>
          </MemoForm>

          
        </MemoSection>
      </Content>
    </Container>
  )
}

export default PushDetail