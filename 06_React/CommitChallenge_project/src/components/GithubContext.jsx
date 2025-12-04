import React, { createContext, useContext, useEffect, useState } from 'react';
const GithubContext = React.createContext();



export const GithubProvider = ({children}) => {
  const [gitUsername, setGitusername] =useState('');
  const[pushHistory,setPushHistory] = useState([]);
  const[status, setStatus] = useState('');
  const[loading,setLoading]= useState(false);
  
  const getTodayPush = async (username)=>{

    const targetUsername = username || gitUsername;
  
    console.log("아이디: ", targetUsername);
    if(!targetUsername && targetUsername ===""){
      alert("깃허브 아이디를 입력해주세요!");
      return;
    }
    setGitusername(targetUsername);
    setLoading(true);
    setStatus('로딩중...');
    setPushHistory([]);
    try{
      const response = await fetch(`https://api.github.com/users/${targetUsername}/events`);  
      if (!response.ok) throw new Error("유저를 찾을 수 없습니다.");
      const events = await response.json();
      const today = new Date().toDateString();


      const todayPushes = events.filter(event=>{
        const eventDate = new Date(event.created_at).toDateString();
        return event.type ==='PushEvent' && eventDate === today
      });


      if(todayPushes.length > 0){
        setStatus('🎉 오늘 push 를 하셨군요! 내일도 꾸준히 해주세요!');
        setPushHistory(todayPushes);
        setLoading(false);
      } else {
        setStatus('😅 오늘 아직 푸쉬내역이 없어요. 잔디 심어야죠');
        setLoading(false);
      }


    } catch(error){
        console.log(error);
        setStatus(" ❌ 에러발생. 아이디 확인해주세요");
        setLoading(false);
    }

}  
const values= {
  gitUsername, setGitusername, pushHistory, status, loading, getTodayPush, setLoading
}

return (
    <GithubContext.Provider value={values}>
      {children}
      </GithubContext.Provider>
  )
}



export const useGithub =() => useContext(GithubContext);
