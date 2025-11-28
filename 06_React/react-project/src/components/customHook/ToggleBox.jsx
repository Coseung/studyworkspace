import React from 'react'
import useToggle from './useToggle'

const ToggleBox = () => {
  const [isView, toggleIsView] = useToggle();

  return (
    <div>
      <button onClick={toggleIsView}>
        {isView ? "숨기기" : "보이기"}
      </button>
    </div>
  )
}

export default ToggleBox