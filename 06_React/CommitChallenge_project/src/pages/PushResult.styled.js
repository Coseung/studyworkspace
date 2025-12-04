import styled from "styled-components";

export const Container = styled.div`
  min-height: 100vh;
  background: linear-gradient(135deg, #dadadaff 0%, #dadadaff 100%);
  padding: 40px 20px;
  width: 600px;
`;

export const Content = styled.div`
  max-width: 800px;
  margin: 0 auto;
`;

export const Header = styled.div`
  background: white;
  border-radius: 16px;
  padding: 32px;
  margin-bottom: 24px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  display: flex;
  justify-content: space-between;
  align-items: center;
`;

export const HeaderLeft = styled.div`
  flex: 1;
`;

export const Title = styled.h1`
  font-size: 32px;
  font-weight: bold;
  color: #333;
  margin-bottom: 8px;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  -webkit-background-clip: text;
  -webkit-text-fill-color: transparent;
  background-clip: text;
`;

export const UserInfo = styled.p`
  font-size: 16px;
  color: #666;
  margin: 0;
`;

export const LogoutButton = styled.button`
  padding: 10px 20px;
  border: none;
  background: #ff4444;
  color: white;
  border-radius: 8px;
  font-size: 14px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;
  margin-top: 20px;

  &:hover {
    background: #cc0000;
    transform: translateY(-2px);
    box-shadow: 0 4px 8px rgba(255, 68, 68, 0.3);
  }
`;

export const ActionBox = styled.div`
  background: white;
  border-radius: 16px;
  padding: 24px;
  margin-bottom: 24px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
  text-align: center;
`;

export const RefreshButton = styled.button`
  padding: 14px 32px;
  border: none;
  color: #ffffff;
  background: linear-gradient(135deg, #667eea 0%, #764ba2 100%);
  border-radius: 8px;
  cursor: pointer;
  font-size: 16px;
  font-weight: 600;
  transition: all 0.2s;
  box-shadow: 0 4px 12px rgba(102, 126, 234, 0.4);

  &:hover {
    transform: translateY(-2px);
    box-shadow: 0 6px 20px rgba(102, 126, 234, 0.5);
  }

  &:disabled {
    background: #ccc;
    cursor: not-allowed;
    box-shadow: none;
    transform: none;
  }
`;

export const StatusMessage = styled.div`
  background: white;
  border-radius: 16px;
  padding: 20px;
  text-align: center;
  font-size: 18px;
  font-weight: 600;
  color: #333;
  margin-bottom: 24px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
`;

export const List = styled.div`
  display: flex;
  flex-direction: column;
  gap: 16px;
`;

export const Item = styled.div`
  background: white;
  border-radius: 12px;
  padding: 20px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  transition: all 0.2s;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.12);
  }
`;

export const Time = styled.div`
  font-size: 14px;
  color: #888;
  margin-bottom: 8px;
  display: flex;
  align-items: center;
  gap: 6px;
`;

export const RepoName = styled.div`
  font-size: 18px;
  font-weight: 600;
  color: #333;
  margin-bottom: 8px;
  display: flex;
  align-items: center;
  gap: 6px;
`;

export const Branch = styled.div`
  font-size: 14px;
  color: #667eea;
  display: flex;
  align-items: center;
  gap: 6px;
  background: #f0f4ff;
  padding: 6px 12px;
  border-radius: 6px;
  display: inline-flex;
  font-weight: 500;
`;

export const EmptyState = styled.div`
  background: white;
  border-radius: 16px;
  padding: 60px 40px;
  text-align: center;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
`;

export const EmptyIcon = styled.div`
  font-size: 64px;
  margin-bottom: 16px;
`;

export const EmptyText = styled.p`
  font-size: 18px;
  color: #666;
  margin: 0;
`;