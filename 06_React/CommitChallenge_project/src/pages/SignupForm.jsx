import React,{useState} from 'react'
import{useAuth} from '../components/UserContext.jsx'
import {
  Container,FormBox, Title,FormGroup, Label, Input, InputGroup, VerifyButton, SubmitButton, ErrorText, SuccessText, LinkText, Link
} from './Signup.styled';
import { ROUTES } from '../routes/routesPath.js';
import { useNavigate } from 'react-router-dom';
export const SignupForm = ({ onSuccess }) => {
   const { signup } = useAuth();
  const [userId, setUserId] = useState('');
  const [password, setPassword] = useState('');
  const [name, setName] = useState('');
  const [githubUsername, setGithubUsername] = useState('');
  const [errors, setErrors] = useState({});
  const [githubVerified, setGithubVerified] = useState(false);
  const [isVerifying, setIsVerifying] = useState(false);
  const navigate =useNavigate();


  const verifyGithub = async () => {
    if(!githubUsername.trim()){
      setErrors(prev => ({...prev, githubUsername :'GitHub 닉네임을 입력하세요'}))
      return;
    }
    setIsVerifying(true);
    try{
      const response = await fetch(`https://api.github.com/users/${githubUsername}`);
      if(response.ok){
        setGithubVerified(true);
        setErrors(prev => ({ ...prev, githubUsername: '' }));

      }else {
        setGithubVerified(false);
        setErrors(prev => ({ ...prev, githubUsername: '존재하지 않는 GitHub 사용자입니다' }));
      }
      

    }catch(e){
       setErrors(prev => ({ ...prev, githubUsername: 'GitHub 확인 중 오류가 발생했습니다' }));

    }finally {
      setIsVerifying(false);
    }
  }
  const handleSubmit =()=>{
    const newErrors ={};
    if (!userId.trim()) newErrors.userId = '아이디를 입력하세요';
    if (!password.trim()) newErrors.password = '비밀번호를 입력하세요';
    if (!name.trim()) newErrors.name = '이름을 입력하세요';
    if (!githubUsername.trim()) newErrors.githubUsername = 'GitHub 닉네임을 입력하세요';
    if (!githubVerified) newErrors.githubUsername = 'GitHub 닉네임 확인이 필요합니다';

    
    if (Object.keys(newErrors).length > 0) {
      setErrors(newErrors);
      return;
    }

    signup({ userId, password, name, githubUsername });
    alert('회원가입이 완료되었습니다!');
    navigate(ROUTES.HOME);
  
  }
  const handleKeyDown = (e) => {
    if (e.key === 'Enter') {
      handleSubmit();
    }
  }
  

  return (
    <Container>
      <FormBox>
        <Title>회원가입</Title>
        
        <FormGroup>
          <Label>아이디</Label>
          <Input
            type="text"
            value={userId}
            onChange={(e) => setUserId(e.target.value)}
            onKeyDown={handleKeyDown}
            placeholder="아이디를 입력하세요"
          />
          {errors.userId && <ErrorText>{errors.userId}</ErrorText>}
        </FormGroup>

        <FormGroup>
          <Label>비밀번호</Label>
          <Input
            type="password"
            value={password}
            onChange={(e) => setPassword(e.target.value)}
            onKeyDown={handleKeyDown}
            placeholder="비밀번호를 입력하세요"
          />
          {errors.password && <ErrorText>{errors.password}</ErrorText>}
        </FormGroup>

        <FormGroup>
          <Label>이름</Label>
          <Input
            type="text"
            value={name}
            onChange={(e) => setName(e.target.value)}
            onKeyDown={handleKeyDown}
            placeholder="이름을 입력하세요"
          />
          {errors.name && <ErrorText>{errors.name}</ErrorText>}
        </FormGroup>

        <FormGroup>
          <Label>GitHub 닉네임</Label>
          <InputGroup>
            <Input
              type="text"
              value={githubUsername}
              onChange={(e) => {
                setGithubUsername(e.target.value);
                setGithubVerified(false);
              }}
              placeholder="GitHub 닉네임"
            />
            <VerifyButton onClick={verifyGithub} disabled={isVerifying}>
              {isVerifying ? '확인 중...' : '확인'}
            </VerifyButton>
          </InputGroup>
          {githubVerified && <SuccessText>✓ GitHub 사용자 확인 완료!</SuccessText>}
          {errors.githubUsername && <ErrorText>{errors.githubUsername}</ErrorText>}
        </FormGroup>

        <SubmitButton onClick={handleSubmit}>
          회원가입
        </SubmitButton>

        <LinkText>
          이미 계정이 있으신가요?{' '}
          <Link onClick={() => navigate(ROUTES.LOGIN)}>로그인하기</Link>
        </LinkText>
      </FormBox>
    </Container>
  )
}
export default SignupForm;
