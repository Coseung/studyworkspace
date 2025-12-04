import styled from 'styled-components';

export const Container = styled.div`
  min-height: 100vh;
  background: linear-gradient(135deg, #dadada 0%, #dadada 100%);
  padding: 40px 20px;
  width : 600px;
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
`;

export const BackButton = styled.button`
  padding: 8px 16px;
  border: none;
  background: #666;
  color: white;
  border-radius: 8px;
  font-size: 14px;
  cursor: pointer;
  margin-bottom: 16px;
  transition: all 0.2s;

  &:hover {
    background: #555;
    transform: translateY(-2px);
  }
`;

export const Title = styled.h1`
  font-size: 28px;
  font-weight: bold;
  color: #333;
  margin-bottom: 16px;
`;

export const InfoBox = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
`;

export const InfoItem = styled.div`
  font-size: 16px;
  color: #666;
  display: flex;
  align-items: center;
  gap: 8px;
`;

export const InfoLabel = styled.span`
  font-weight: 600;
  color: #333;
`;

export const MemoSection = styled.div`
  background: white;
  border-radius: 16px;
  padding: 32px;
  margin-bottom: 24px;
  box-shadow: 0 4px 6px rgba(0, 0, 0, 0.1);
`;

export const SectionTitle = styled.h2`
  font-size: 22px;
  font-weight: bold;
  color: #333;
  margin-bottom: 16px;
`;

export const MemoForm = styled.div`
  display: flex;
  flex-direction: column;
  gap: 12px;
  margin-bottom: 24px;
`;

export const Textarea = styled.textarea`
  width: 100%;
  min-height: 120px;
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

export const AddButton = styled.button`
  padding: 12px 24px;
  border: none;
  background: #5833ff;
  color: white;
  border-radius: 8px;
  font-size: 16px;
  font-weight: 600;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #4526cc;
  }

  &:disabled {
    background: #ccc;
    cursor: not-allowed;
  }
`;

export const MemoList = styled.div`
  display: flex;
  flex-direction: column;
  gap: 16px;
`;

export const MemoItem = styled.div`
  background: #f9f9f9;
  border-radius: 12px;
  padding: 20px;
  border: 1px solid #e2e2e2;
`;

export const MemoHeader = styled.div`
  display: flex;
  justify-content: space-between;
  align-items: center;
  margin-bottom: 12px;
`;

export const MemoDate = styled.div`
  font-size: 14px;
  color: #888;
`;

export const MemoActions = styled.div`
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
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #cc0000;
  }
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
  gap: 8px;
`;

export const SaveButton = styled.button`
  padding: 6px 12px;
  border: none;
  background: #00aa00;
  color: white;
  border-radius: 6px;
  font-size: 12px;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #008800;
  }
`;

export const CancelButton = styled.button`
  padding: 6px 12px;
  border: none;
  background: #999;
  color: white;
  border-radius: 6px;
  font-size: 12px;
  cursor: pointer;
  transition: all 0.2s;

  &:hover {
    background: #777;
  }
`;

export const EmptyMemo = styled.div`
  text-align: center;
  padding: 40px;
  color: #999;
  font-size: 16px;
`;