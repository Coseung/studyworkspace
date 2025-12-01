import React, { useContext, useState, useEffect} from "react";

const UserContext = React.createContext();

export const UserProvider = ({children}) => {

    const [users, setUsers] = useState([{
        name: "홍길동",
        age: 45,
        isOnline:  '🟢 온라인 상태입니다.' 
        
    },{name: "최승호",
        age: 25,
        isOnline:  '🔴 오프라인 상태입니다.' 
        
    },{name: "박명수",
        age: 22,
        isOnline:  '🟢 온라인 상태입니다.'
        
    }])

    
    const addUser = (newUser) =>{
      
      setUsers((prev) =>[...prev, newUser]); 
      
    }
    
    useEffect(() => {
      console.log("업데이트된 users:", users);
    }, [users]);

    return (
        <UserContext.Provider value={{users, addUser}}>
            {children}
        </UserContext.Provider>
    )
}



export const useUser = () => {
    return useContext(UserContext);
}