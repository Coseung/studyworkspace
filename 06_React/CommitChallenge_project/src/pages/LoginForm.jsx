import React from 'react'
import { useAuth } from '../components/UserContext.jsx'
import { useState } from 'react';
import { ROUTES } from '../routes/routesPath.js';
import { useNavigate } from 'react-router-dom';
import {
  Container,
  FormBox,
  Title,
  FormGroup,
  Label,
  Input,
  SubmitButton,
  ErrorText,
  LinkText,
  Link
} from './Login.styled';

import { useEffect } from 'react';

const LoginForm = () => {
  const {login} = useAuth();
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const [error, setError] = useState('');
  const navigate = useNavigate();


  // useEffect(() => {
  //   console.log(localStorage.getItem('users'));
  // },);

  const handleSubmit = () => {
    if (!userId.trim() || !password.trim()) {
      setError('아이디와 비밀번호를 입력하세요');
      return;
    }


    const success = login(userId, password);
    
    if (success) {
      navigate(ROUTES.HOME);
    } else {
      setError('아이디 또는 비밀번호가 일치하지 않습니다');
    }
  };
   const handleKeyDown = (e) => {
    if (e.key === 'Enter') {
      handleSubmit();
    }
  };

  return (
    <Container>
      <FormBox>
        <Title>로그인</Title>
        
        <FormGroup>
          <Label>아이디</Label>
          <Input
            type="text"
            value={userId}
            onChange={(e) => {
              setUserId(e.target.value);
              setError('');
            }}
            onKeyDown={handleKeyDown}
            placeholder="아이디를 입력하세요"
          />
        </FormGroup>

        <FormGroup>
          <Label>비밀번호</Label>
          <Input
            type="password"
            value={password}
            onChange={(e) => {
              setPassword(e.target.value);
              setError('');
            }}
            onKeyDown={handleKeyDown}
            placeholder="비밀번호를 입력하세요"
          />
        </FormGroup>

        {error && <ErrorText>{error}</ErrorText>}

        <SubmitButton onClick={handleSubmit}>
          로그인
        </SubmitButton>

        <LinkText>
          계정이 없으신가요?{' '}
          <Link onClick={() => navigate(ROUTES.SIGNUP)}>회원가입하기</Link>
        </LinkText>
      </FormBox>
    </Container>
  )
}

export default LoginForm