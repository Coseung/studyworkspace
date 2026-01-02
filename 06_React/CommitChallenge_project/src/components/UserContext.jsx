import React, { useState, createContext, useContext } from 'react';

const AuthContext = createContext();

export const UserProvider = ({ children }) => {
  const [currentUser, setCurrentUser] = useState(() => {
    const user = localStorage.getItem('currentUser');
    return user ? JSON.parse(user) : null;
  });
  const signup = async (userData) => {
    try {
      const response = await fetch("http://localhost:8888/member/signup", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify(userData)
      })
      if (!response.ok) {
        const error = await response.text();
        throw new Error(error || "회원가입 실패")
      }

      const result = await response.json();
      console.log(result);
      return result

    } catch (e) {
      console.error("회원가입에러: ", e.massage);
      return null;

    }
  }

  const login = async (id, password) => {
    try {
      const response = await fetch("http://localhost:8888/member/login", {
        method: "POST",
        headers: {
          "Content-Type": "application/json"
        },
        body: JSON.stringify({
          "userId": id,
          "password": password
        })

      })
      if (!response.ok) {
        const error = await response.text();
        throw new Error(error || "로그인 실패")
      }
      const userData = await response.json();
      console.log("서버 응답 성공:", userData);

      setCurrentUser(userData);
      localStorage.setItem('currentUser', JSON.stringify(userData));

      return userData;
    } catch (e) {
      console.error("로그인에러: ", e.message);
      return null;

    }

  }
  const logout = () => {
    setCurrentUser(null);
    localStorage.removeItem('currentUser');
  };


  const value = {
    currentUser,
    signup,
    login,
    logout,
  };

  return (
    <AuthContext.Provider value={value}>
      {children}
    </AuthContext.Provider>
  )
}

export const useAuth = () => {
  const context = useContext(AuthContext);
  return context;
};
