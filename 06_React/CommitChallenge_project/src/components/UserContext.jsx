import React, { useState, createContext, useContext } from 'react';

const AuthContext = createContext();

export const UserProvider = ({cildren}) => {
  const [currentUser, setCurrentUser] =useState(()=>{
    const user =localStorage.getItem('currentUser');
    return user ? JSON.parse(user) : null;
  });
  
  
  
  return (
    <div>UserContext</div>
  )
}

export const useAuth = () => {
  const context = useContext(AuthContext);
  return context;
};
