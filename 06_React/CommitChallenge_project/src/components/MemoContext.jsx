import React, { createContext, useContext, useState, useEffect } from 'react';

const MemoContext = createContext();

export const useMemo = () => {
  const context = useContext(MemoContext);
  return context;
};

export const MemoProvider = ({ children }) => {
  const [memos, setMemos] = useState(() => {
    const savedMemos = localStorage.getItem('pushMemos');
    return savedMemos ? JSON.parse(savedMemos) : [];
  });

  useEffect(() => {
    localStorage.setItem('pushMemos', JSON.stringify(memos));
  }, [memos]);

  const addMemo = (pushId, pushData, memoText) => {
    const newMemo = {
      id: Date.now(),
      pushId,
      date: pushData.created_at,
      repoName: pushData.repo.name,
      branch: pushData.payload.ref ? pushData.payload.ref.replace('refs/heads/', '') : 'main',
      memo: memoText,
      createdAt: new Date().toISOString(),
    };

    setMemos(prev => [...prev, newMemo]);
    return newMemo;
  };

  const updateMemo = (id, newMemoText) => {
    setMemos(prev =>
      prev.map(memo =>
        memo.id === id ? { ...memo, memo: newMemoText } : memo
      )
    );
  };

  const deleteMemo = (id) => {
    setMemos(prev => prev.filter(memo => memo.id !== id));
  };

  const getMemosByPushId = (pushId) => {
    return memos.filter(memo => memo.pushId === pushId);
  };

  const value = {
    memos,
    addMemo,
    updateMemo,
    deleteMemo,
    getMemosByPushId,
  };

  return (
    <MemoContext.Provider value={value}>
      {children}
    </MemoContext.Provider>
  );
};