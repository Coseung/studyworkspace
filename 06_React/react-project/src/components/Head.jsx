import React from "react";

const Head = ({type, children}) => {

  if(props?.type === "h2"){
   return <h1> 안녕하세요 </h1>

  }
  return(
    <>
      <h1>안녕하세요</h1>
      {children}
    </>
  )
}

export default Head