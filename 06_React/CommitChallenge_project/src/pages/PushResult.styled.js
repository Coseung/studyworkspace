import styled from "styled-components";

export const Container = styled.div`
  min-height: 100vh;
background: linear-gradient(135deg, #dadada 0%, #dadada 100%);  padding: 40px 20px;
  display: flex;
  flex-direction: column;
  align-items: center;
  width :600px;
`;

export const Content = styled.div`
  max-width: 800px;
  width: 100%;
  margin: 0 auto;
`;

export const Header = styled.div`
  background: white;
  border-radius: 16px;
  padding: 32px;
  margin-bottom: 24px;
  box-shadow: 0 4px 12px rgba(119, 136, 115, 0.15);
  display: flex;
  justify-content: space-between;
  align-items: center;
  border: 2px solid #F1F3E0;
`;

export const HeaderLeft = styled.div`
  flex: 1;
`;

export const Title = styled.h1`
  font-size: 32px;
  font-weight: bold;
  color: #778873;
  margin-bottom: 8px;
`;

export const UserInfo = styled.p`
  font-size: 16px;
  color: #778873;
  margin: 0;
  opacity: 0.8;
`;

export const MemoButton = styled.button`
  padding: 14px 32px;
  border: none;
  color: white;
  background: #A1BC98;
  border-radius: 8px;
  cursor: pointer;
  font-size: 16px;
  font-weight: 600;
  transition: all 0.2s;
  box-shadow: 0 4px 12px rgba(161, 188, 152, 0.3);

  &:hover {
    transform: translateY(-2px);
    background: #778873;
    box-shadow: 0 6px 20px rgba(119, 136, 115, 0.4);
  }
`;

export const LogoutButton = styled.button`
  padding: 12px 24px;
  border: none;
  background: white;
  color: #778873;
  border-radius: 8px;
  font-size: 14px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;
  margin-top: 24px;

  &:hover {
    background: #778873;
    color: white;
    transform: translateY(-2px);
    box-shadow: 0 4px 12px rgba(119, 136, 115, 0.3);
  }
`;

export const ActionBox = styled.div`
  background: white;
  border-radius: 16px;
  padding: 24px;
  margin-bottom: 24px;
  box-shadow: 0 4px 12px rgba(119, 136, 115, 0.15);
  text-align: center;
  display: flex;
  justify-content: center;
  gap: 16px;
  border: 2px solid #F1F3E0;
`;

export const RefreshButton = styled.button`
  padding: 14px 32px;
  border: none;
  color: white;
  background: #778873;
  border-radius: 8px;
  cursor: pointer;
  font-size: 16px;
  font-weight: 600;
  transition: all 0.2s;
  box-shadow: 0 4px 12px rgba(119, 136, 115, 0.3);

  &:hover {
    transform: translateY(-2px);
    background: #A1BC98;
    box-shadow: 0 6px 20px rgba(161, 188, 152, 0.4);
  }

  &:disabled {
    background: #D2DCB6;
    cursor: not-allowed;
    box-shadow: none;
    transform: none;
    opacity: 0.6;
  }
`;

export const StatusMessage = styled.div`
  background: white;
  border-radius: 16px;
  padding: 20px;
  text-align: center;
  font-size: 18px;
  font-weight: 600;
  color: #778873;
  margin-bottom: 24px;
  box-shadow: 0 4px 12px rgba(119, 136, 115, 0.15);
  border: 2px solid #D2DCB6;
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
  box-shadow: 0 2px 8px rgba(119, 136, 115, 0.1);
  transition: all 0.3s;
  cursor: pointer;
  border: 2px solid transparent;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 20px rgba(119, 136, 115, 0.2);
    border-color: #A1BC98;
  }
`;

export const Time = styled.div`
  font-size: 14px;
  color: #778873;
  margin-bottom: 8px;
  display: flex;
  align-items: center;
  gap: 6px;
  opacity: 0.8;
`;

export const RepoName = styled.div`
  font-size: 18px;
  font-weight: 600;
  color: #778873;
  margin-bottom: 8px;
  display: flex;
  align-items: center;
  gap: 6px;
`;

export const Branch = styled.div`
  font-size: 14px;
  color: #778873;
  display: inline-flex;
  align-items: center;
  gap: 6px;
  background: #F1F3E0;
  padding: 6px 12px;
  border-radius: 6px;
  font-weight: 500;
  border: 1px solid #D2DCB6;
`;

export const EmptyState = styled.div`
  background: white;
  border-radius: 16px;
  padding: 60px 40px;
  text-align: center;
  box-shadow: 0 4px 12px rgba(119, 136, 115, 0.15);
  border: 2px solid #F1F3E0;
`;

export const EmptyIcon = styled.div`
  font-size: 64px;
  margin-bottom: 16px;
  filter: grayscale(30%);
`;

export const EmptyText = styled.p`
  font-size: 18px;
  color: #778873;
  margin: 0;
  opacity: 0.8;
`;