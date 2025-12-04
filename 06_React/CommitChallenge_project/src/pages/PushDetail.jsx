import React from 'react'
import { useParams } from 'react-router-dom'

const PushDetail = () => {
  const {detailId} = useParams();


  return (
    <div>{detailId}</div>
  )
}

export default PushDetail