import styled from 'styled-components';

export const Container = styled.div`
  min-height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background: #f5f5f5;
  padding: 20px;
  width: 600px;
`;

export const FormBox = styled.div`
  background: white;
  border-radius: 8px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.1);
  padding: 40px;
  width: 100%;
  max-width: 400px;
`;

export const Title = styled.h1`
  font-size: 28px;
  font-weight: bold;
  color: #333;
  margin-bottom: 8px;
  text-align: center;
`;

export const FormGroup = styled.div`
  margin-bottom: 20px;
`;

export const Label = styled.label`
  display: block;
  font-size: 14px;
  font-weight: 500;
  color: #333;
  margin-bottom: 8px;
`;

export const Input = styled.input`
  width: 100%;
  padding: 12px;
  border: 1px solid #e2e2e2;
  border-radius: 4px;
  font-size: 14px;
  outline: none;
  box-sizing: border-box;

  &:focus {
    border-color: #5833ff;
  }
`;

export const InputGroup = styled.div`
  display: flex;
  gap: 8px;
`;

export const VerifyButton = styled.button`
  padding: 12px 20px;
  border: none;
  background: #666;
  color: white;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;
  white-space: nowrap;

  &:hover {
    background: #555;
  }

  &:disabled {
    background: #ccc;
    cursor: not-allowed;
  }
`;

export const SubmitButton = styled.button`
  width: 100%;
  padding: 12px;
  border: none;
  background: #5833ff;
  color: white;
  border-radius: 4px;
  font-size: 16px;
  font-weight: 500;
  cursor: pointer;
  margin-top: 8px;

  &:hover {
    background: #4526cc;
  }
`;

export const ErrorText = styled.p`
  color: #ff4444;
  font-size: 13px;
  margin-top: 4px;
`;

export const SuccessText = styled.p`
  color: #00aa00;
  font-size: 13px;
  margin-top: 4px;
`;

export const LinkText = styled.p`
  text-align: center;
  font-size: 14px;
  color: #666;
  margin-top: 20px;
`;

export const Link = styled.span`
  color: #5833ff;
  cursor: pointer;
  text-decoration: underline;

  &:hover {
    color: #4526cc;
  }
`;