import React from 'react'
import { useGithub } from '../components/GithubContext';
import {useNavigate} from 'react-router-dom';
import { useEffect } from 'react';
import { useAuth } from '../components/UserContext';
import { 
  Button, 
  Container, 
  Item, 
  List, 
  RepoName, 
  SearchBox, 
  StatusMessage, 
  Time, 
  Title, 
  LogoutButton, 
  Header,
  UserInfo 
} from './PushResult.styled';
import useInput from '../components/useInput';
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

  return (
    <Container>
      <Header>
        <div>
          <Title>깃 허브 오늘의 잔디심기</Title>
          <UserInfo>
            {currentUser?.name}님 (@{currentUser?.githubUsername})
          </UserInfo>
        </div>
        <LogoutButton onClick={handleLogout}>로그아웃</LogoutButton>
      </Header>
      
      <SearchBox>
        <Button onClick={handleRefresh} disabled={loading}>
          {loading ? '확인 중...' : '🔄 새로고침'}
        </Button>
      </SearchBox>

      <StatusMessage>{status}</StatusMessage>
      
      <List>
        {pushHistory.map(push => (
          <Item key={push.id}>
            <Time>🕒 {new Date(push.created_at).toLocaleTimeString()}</Time>
            <RepoName>📂 {push.repo.name}</RepoName>
            <div>
              🔀 Branch: {push.payload.ref ? push.payload.ref.replace('refs/heads/', '') : 'main'}
            </div>
          </Item>
        ))}
      </List>
    </Container>
  )
}

export default PushResult