import React, { useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import { useGithub } from '../components/GithubContext.jsx';
import { useAuth } from '../components/UserContext.jsx';
import { ROUTES } from '../routes/routesPath.js';
import { WiTime1,FaFolderOpen,FaCodeBranch,CiMemoPad, GiHighGrass } from "../components/icons/icons.js";

import { 
  Container,
  Content,
  Header,
  HeaderLeft,
  Title,
  UserInfo,
  LogoutButton,
  ActionBox,
  RefreshButton,
  StatusMessage,
  List,
  Item,
  Time,
  RepoName,
  Branch,
  EmptyState,
  EmptyIcon,
  EmptyText,
  MemoButton
} from './PushResult.styled';

const PushResult = () => {
  const { setGitusername, pushHistory, status, getTodayPush, loading } = useGithub();
  const { currentUser, logout } = useAuth();
  const navigate = useNavigate();

  useEffect(() => {
    if (currentUser?.githubUsername) {
      setGitusername(currentUser.githubUsername);
      getTodayPush(currentUser.githubUsername);
    }
  }, [currentUser]);

  const handleRefresh = () => {
    if (currentUser?.githubUsername) {
      getTodayPush(currentUser.githubUsername);
    }
  };

  const handleLogout = () => {
    logout();
    navigate(ROUTES.LOGIN);
  };

  const handleDetail =(detailId) =>{
    navigate(ROUTES.DETAIL(detailId))
  };
   const handleMemoList = () => {
    navigate(ROUTES.MEMOLIST);
  };
  return (
    <Container>
      
      <Content>
        <Header>
          <HeaderLeft>
            <Title>🌱 깃허브 오늘의 잔디심기</Title>
            <UserInfo>
              {currentUser?.name}님 (@{currentUser?.githubUsername})
            </UserInfo>
          </HeaderLeft>
        </Header>
        
        <ActionBox>
          <RefreshButton onClick={handleRefresh} disabled={loading}>
            {loading ? '⏳ 확인 중...' : ' 새로고침'}
          </RefreshButton>
          <MemoButton onClick={handleMemoList}>
            메모 목록
          </MemoButton>
        </ActionBox>

        {status && <StatusMessage>{status}</StatusMessage>}
        {pushHistory.length > 0 ? (
          <List>
            {pushHistory.map(push => (
              <Item key={push.id} onClick={()=> {handleDetail(push.id)}}>
                <Time>
                  <WiTime1/> {new Date(push.created_at).toLocaleTimeString('ko-KR')}
                </Time>
                <RepoName>
                  <FaFolderOpen/> {push.repo.name}
                </RepoName>
                <Branch>
                  <FaCodeBranch/> {push.payload.ref ? push.payload.ref.replace('refs/heads/', '') : 'main'}
                </Branch>
              </Item>
            ))}
          </List>
        ) : (
          !loading && status && (
            <EmptyState>
              <EmptyIcon><GiHighGrass/></EmptyIcon>
              <EmptyText>아직 커밋이 없습니다</EmptyText>
            </EmptyState>
          )
        )}
      </Content>
      <LogoutButton onClick={handleLogout}>로그아웃</LogoutButton>

    </Container>
  );
};

export default PushResult;