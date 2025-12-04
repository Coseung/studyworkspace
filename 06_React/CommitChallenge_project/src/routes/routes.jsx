import React from 'react';
import { BrowserRouter, Route, Routes, Navigate } from 'react-router-dom';
import { ROUTES } from './routesPath.js';
import { useAuth } from '../components/UserContext.jsx';
import LoginForm from '../pages/LoginForm.jsx';
import SignupForm from '../pages/SignupForm.jsx';
import PushResult from '../pages/PushResult.jsx';
import PushDetail from '../pages/PushDetail.jsx';
import MemoList from '../pages/MemoList.jsx';
const AppRoutes = () => {
  const {currentUser} = useAuth();
  return (
    <BrowserRouter>
      <Routes>

        {/* 로그인 페이지 (로그인한 사용자는 HOME으로) */}
        <Route 
          path={ROUTES.LOGIN}
          element={
            !currentUser ? <LoginForm /> : <Navigate to={ROUTES.HOME} />
          }/>

        {/* 회원가입 페이지 (로그인 상태면 HOME으로) */}
        <Route 
          path={ROUTES.SIGNUP}
          element={
            !currentUser ? <SignupForm /> : <Navigate to={ROUTES.HOME} />
          }/>

        {/* 메인 페이지 (로그인 필요) */}
        <Route
          path={ROUTES.HOME}
          element={
            currentUser ? <PushResult /> : <Navigate to={ROUTES.LOGIN} />
          }/>

        <Route
          path={ROUTES.MEMOLIST}
          element={
            currentUser ? <MemoList /> : <Navigate to={ROUTES.MEMOLIST} />
          }/>
        {/* 잘못된 경로는 HOME으로 */}
        <Route path="*" element={<Navigate to={ROUTES.HOME} />} />
          {/* 디테일 페이지 */}
        <Route path='detail/:detailId' element={ currentUser ? <PushDetail/> : <Navigate to={ROUTES.LOGIN}/> } />

      </Routes>
    </BrowserRouter>
  );
};

export default AppRoutes;