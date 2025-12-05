import styled from 'styled-components';

export const Container = styled.div`
  min-height: 100vh;
  background: linear-gradient(135deg, #dadada 0%, #dadada 100%);
  padding: 40px 20px;
  width: 600px;
`;

export const Content = styled.div`
  max-width: 1000px;
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

export const Title = styled.h1`
  font-size: 32px;
  font-weight: bold;
  color: #333;
  margin: 0;
  
`;

export const BackButton = styled.button`
  padding: 10px 20px;
  border: none;
  background: #666;
  color: white;
  border-radius: 8px;
  font-size: 14px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #555;
    transform: translateY(-2px);
  }
`;

export const MemoGrid = styled.div`
  display: grid;
  grid-template-columns: repeat(auto-fill, minmax(350px, 1fr));
  gap: 20px;
`;

export const MemoCard = styled.div`
  background: white;
  border-radius: 12px;
  padding: 24px;
  box-shadow: 0 2px 8px rgba(0, 0, 0, 0.08);
  transition: all 0.2s;

  &:hover {
    transform: translateY(-4px);
    box-shadow: 0 8px 16px rgba(0, 0, 0, 0.12);
  }
`;

export const CardHeader = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: flex-start;
  margin-bottom: 16px;
  padding-bottom: 16px;
  border-bottom: 2px solid #f0f0f0;
`;

export const CardDate = styled.div`
  font-size: 14px;
  color: #888;
`;

export const CardActions = styled.div`
  display: flex;
  gap: 8px;
`;

export const EditButton = styled.button`
  padding: 6px 12px;
  border: none;
  background: #667eea;
  color: white;
  border-radius: 6px;
  font-size: 12px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #5568d3;
  }
`;

export const DeleteButton = styled.button`
  padding: 6px 12px;
  border: none;
  background: #ff4444;
  color: white;
  border-radius: 6px;
  font-size: 12px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #cc0000;
  }
`;

export const InfoSection = styled.div`
  display: flex;
  flex-direction: column;
  gap: 10px;
  margin-bottom: 16px;
`;

export const InfoItem = styled.div`
  display: flex;
  align-items: center;
  gap: 8px;
  font-size: 14px;
`;

export const InfoIcon = styled.span`
  font-size: 16px;
`;

export const InfoLabel = styled.span`
  font-weight: 600;
  color: #333;
`;

export const InfoValue = styled.span`
  color: #666;
`;

export const MemoContent = styled.div`
  background: #f9f9f9;
  border-radius: 8px;
  padding: 16px;
  margin-top: 12px;
`;

export const MemoText = styled.p`
  font-size: 15px;
  color: #333;
  line-height: 1.6;
  white-space: pre-wrap;
  word-break: break-word;
  margin: 0;
`;

export const EditForm = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
  margin-top: 12px;
`;

export const Textarea = styled.textarea`
  width: 100%;
  min-height: 100px;
  padding: 12px;
  border: 1px solid #e2e2e2;
  border-radius: 8px;
  font-size: 14px;
  outline: none;
  resize: vertical;
  box-sizing: border-box;

  &:focus {
    border-color: #5833ff;
  }
`;

export const EditActions = styled.div`
  display: flex;
  gap: 8px;
  justify-content: flex-end;
`;

export const SaveButton = styled.button`
  padding: 8px 16px;
  border: none;
  background: #00aa00;
  color: white;
  border-radius: 6px;
  font-size: 14px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #008800;
  }
`;

export const CancelButton = styled.button`
  padding: 8px 16px;
  border: none;
  background: #999;
  color: white;
  border-radius: 6px;
  font-size: 14px;
  font-weight: 500;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #777;
  }
`;

export const EmptyState = styled.div`
  background: white;
  border-radius: 16px;
  padding: 80px 40px;
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