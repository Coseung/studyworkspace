import React from 'react'
import { useGithub } from '../components/GithubContext';

import { Button, CommitItem, CommitList, Container, Input, Item, List, RepoName, SearchBox, StatusMessage, Time, Title } from './PushResult.styled';

import useInput from '../components/useInput';
const PushResult = () => {

  const { username, setGitusername, pushHistory, status, getTodayPush, loading, setLoading } = useGithub();
  const GituserId = useInput('')
  const handleKeyDown = (e) => {
    if(e.key === 'Enter'){
      const username = e.target.value.trim();
      setGitusername(username);
      getTodayPush(username); 
    }
  }
  
  const handleOnclick = () => {
    const username = GituserId.value.trim();
    setGitusername(username);
    getTodayPush(username); 
  }
  

  return (
    <Container>
      <Title>깃 허브 오늘의 잔디심기</Title>
      <SearchBox>
        <Input
        type="text"
        placeholder="깃허브 아이디 입력"
        {...GituserId}
        onKeyDown={handleKeyDown}
        >
        </Input>

        <Button onClick={handleOnclick} disabled={loading}>
          {loading ? '검색 중...' : '확인하기'}
        </Button>
        
      </SearchBox>
        <StatusMessage>{status}</StatusMessage>
        <List>
        {pushHistory.map(push => (
            <Item key={push.id}>
                <Time>🕒 {new Date(push.created_at).toLocaleTimeString()}</Time>
                <RepoName>📂 {push.repo.name}</RepoName>
                
                <CommitList>
                 Branch: {push.payload.ref? push.payload.ref.replace('refs/heads/', '') : 'main'}
                </CommitList>
            </Item>
        ))}
      </List>
      </Container>
  )
}

export default PushResult