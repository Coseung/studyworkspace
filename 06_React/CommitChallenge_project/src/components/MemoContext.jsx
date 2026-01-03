import React, { createContext, useContext, useState, useEffect } from 'react';
import { useAuth } from './UserContext.jsx';

const MemoContext = createContext();

export const useMemo = () => {
  const context = useContext(MemoContext);
  return context;
};

export const MemoProvider = ({ children }) => {
  const { currentUser } = useAuth();
  const [memos, setMemos] = useState([]);
  const [loading, setLoading] = useState(false);
  const [error, setError] = useState(null);

  const API_BASE_URL = 'http://localhost:8888/api/memos';

  // 메모 목록 가져오기
  const fetchMemos = async () => {
    if (!currentUser?.id) return;

    setLoading(true);
    setError(null);

    try {
      const response = await fetch(`${API_BASE_URL}?memberId=${currentUser.id}`, {
        headers: {
          'Authorization': `Bearer ${currentUser.token}`
        }
      });

      if (!response.ok) {
        throw new Error('메모를 불러오는데 실패했습니다.');
      }

      const data = await response.json();
      setMemos(data);
    } catch (err) {
      console.error('메모 가져오기 에러:', err);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // 컴포넌트 마운트 시 메모 가져오기
  useEffect(() => {
    if (currentUser?.id) {
      fetchMemos();
    } else {
      setMemos([]);
    }
  }, [currentUser?.id]);

  // 메모 추가
  const addMemo = async (pushId, pushData, memoText) => {
    if (!currentUser?.id) {
      setError('로그인이 필요합니다.');
      return null;
    }

    setLoading(true);
    setError(null);

    console.log("푸시날짜 ", pushData.created_at)
    try {
      const requestData = {
        pushId: pushId,
        pushDate: pushData.created_at,
        repoName: pushData.repo.name,
        branch: pushData.payload.ref
          ? pushData.payload.ref.replace('refs/heads/', '')
          : 'main',
        memo: memoText,
        memberId: currentUser.id,
      };

      const response = await fetch(API_BASE_URL, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${currentUser.token}`
        },
        body: JSON.stringify(requestData),
      });

      if (!response.ok) {
        throw new Error('메모 추가에 실패했습니다.');
      }

      const newMemo = await response.json();
      setMemos(prev => [newMemo, ...prev]);
      return newMemo;
    } catch (err) {
      console.error('메모 추가 에러:', err);
      setError(err.message);
      return null;
    } finally {
      setLoading(false);
    }
  };

  // 메모 수정
  //여기도
  const updateMemo = async (id, newMemoText) => {
    if (!currentUser?.id) {
      setError('로그인이 필요합니다.');
      return;
    }

    setLoading(true);
    setError(null);

    try {
      const response = await fetch(`${API_BASE_URL}/${id}?memberId=${currentUser.id}`, {
        method: 'PUT',
        headers: {
          'Content-Type': 'application/json',
          'Authorization': `Bearer ${currentUser?.token}`
        },
        body: JSON.stringify({ memo: newMemoText }),
      });

      if (!response.ok) {
        throw new Error('메모 수정에 실패했습니다.');
      }

      const updatedMemo = await response.json();
      setMemos(prev =>
        prev.map(memo => (memo.id === id ? updatedMemo : memo))
      );
    } catch (err) {
      console.error('메모 수정 에러:', err);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // 메모 삭제
  const deleteMemo = async (id) => {
    if (!currentUser?.id) {
      setError('로그인이 필요합니다.');
      return;
    }

    setLoading(true);
    setError(null);
    
    //어소리제이션 인가 추가
    try {
      const response = await fetch(`${API_BASE_URL}/${id}?memberId=${currentUser.id}`, {
        method: 'DELETE',
        headers: {
          'Authorization': `Bearer ${currentUser.token}`
        }
      });

      if (!response.ok) {
        throw new Error('메모 삭제에 실패했습니다.');
      }

      setMemos(prev => prev.filter(memo => memo.id !== id));
    } catch (err) {
      console.error('메모 삭제 에러:', err);
      setError(err.message);
    } finally {
      setLoading(false);
    }
  };

  // pushId로 메모 조회
  //여기도
  const getMemosByPushId = async (pushId) => {
    if (!currentUser?.id) return [];

    try {
      const response = await fetch(
        `${API_BASE_URL}/push/${pushId}?memberId=${currentUser.id}`,
        {
          headers: {
            'Authorization': `Bearer ${currentUser.token}`
          }
        }
      );

      if (!response.ok) {
        throw new Error('메모를 불러오는데 실패했습니다.');
      }

      const data = await response.json();
      return data;
    } catch (err) {
      console.error('pushId로 메모 가져오기 에러:', err);
      return memos.filter(memo => memo.pushId === pushId);
    }
  };

  const value = {
    memos,
    loading,
    error,
    addMemo,
    updateMemo,
    deleteMemo,
    getMemosByPushId,
    fetchMemos,
  };

  return (
    <MemoContext.Provider value={value}>
      {children}
    </MemoContext.Provider>
  );
};