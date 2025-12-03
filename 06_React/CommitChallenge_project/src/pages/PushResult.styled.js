import styled from "styled-components";

export const Container = styled.div`
  max-width: 800px;
  margin: 0 auto;
  padding: 40px 20px;
`;

export const Header = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 24px;
`;

export const Title = styled.h1`
  font-size: 28px;
  font-weight: bold;
  color: #333;
  margin-bottom: 4px;
`;

export const UserInfo = styled.p`
  font-size: 14px;
  color: #666;
  margin: 4px 0;
`;

export const LogoutButton = styled.button`
  padding: 8px 16px;
  border: none;
  background: #ff4444;
  color: white;
  border-radius: 4px;
  font-size: 14px;
  cursor: pointer;

  &:hover {
    background: #cc0000;
  }
`;

export const SearchBox = styled.div`
  display: flex;
  gap: 12px;
  margin-bottom: 24px;
  justify-content: center;
`;

export const Button = styled.button`
  padding: 12px 24px;
  border: none;
  color: #ffffff;
  background: #5833ff;
  border-radius: 4px;
  cursor: pointer;
  font-size: 16px;
  font-weight: 500;

  &:hover {
    background: #4526cc;
  }

  &:disabled {
    background: #ccc;
    cursor: not-allowed;
  }
`;

export const StatusMessage = styled.div`
  text-align: center;
  padding: 16px;
  font-size: 18px;
  font-weight: 500;
  color: #333;
  margin-bottom: 20px;
`;

export const List = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

export const Item = styled.div`
  background: white;
  border: 1px solid #e2e2e2;
  border-radius: 8px;
  padding: 16px;
  box-shadow: 0 2px 4px rgba(0, 0, 0, 0.05);
`;

export const Time = styled.div`
  font-size: 14px;
  color: #666;
  margin-bottom: 8px;
`;

export const RepoName = styled.div`
  font-size: 16px;
  font-weight: 600;
  color: #333;
  margin-bottom: 8px;
`;