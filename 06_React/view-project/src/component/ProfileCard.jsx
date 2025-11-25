import React from "react";
import styled from "styled-components";

const Name = styled.h2`
  font-size: 24px;
  font-weight: bold;
  margin: 0 0 8px 0;
  color: #333;
`;

const Age = styled.p`
  font-size: 16px;
  margin: 0 0 12px 0;
  color: #666;
`;

const Status = styled.p`
  font-size: 14px;
  font-weight: 500;
  margin: 0;
  color: ${props => props.isOnline ? '#4CAF50' : '#9E9E9E'};
`;

function ProfileCard({name, age, isOnline}){

  return(
    <div>
      <Name>이름 : {name}
      </Name>
      <Age>
        나이 : {age}
      </Age>
      <Status isOnline={isOnline}>
        {isOnline ? '🟢 온라인 상태입니다.' : '🔴 오프라인 상태입니다.'}
      </Status>
    </div>
  )
}

export default ProfileCard