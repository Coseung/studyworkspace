import { useState } from 'react'
import reactLogo from './assets/react.svg'
import viteLogo from '/vite.svg'
import './App.css'
import Head from './components/Head'
function App() {
  const [count, setCount] = useState(0)

  const videoList=[{
    title : "[추석특집] 빵빵이의일상!",
    channelNmae: "빵빵이의 일상 ",
    sumbnail:"https://i.ytimg.com/vi/pHGfBQggFlQ/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLBAdS1mA3RtmazmntdllHVkC8AmRw",
    views: "8.3만",
  },{
    title : "[추석특집] 빵빵이의일상!",
    channelNmae: "빵빵이의 일상 ",
    sumbnail:"https://i.ytimg.com/vi/pHGfBQggFlQ/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLBAdS1mA3RtmazmntdllHVkC8AmRw",
    views: "8.3만",
  },{
    title : "[추석특집] 빵빵이의일상!",
    channelNmae: "빵빵이의 일상 ",
    sumbnail:"https://i.ytimg.com/vi/pHGfBQggFlQ/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLBAdS1mA3RtmazmntdllHVkC8AmRw",
    views: "8.3만",
  },{
    title : "[추석특집] 빵빵이의일상!",
    channelNmae: "빵빵이의 일상 ",
    sumbnail:"https://i.ytimg.com/vi/pHGfBQggFlQ/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLBAdS1mA3RtmazmntdllHVkC8AmRw",
    views: "8.3만",
  },{
    title : "[추석특집] 빵빵이의일상!",
    channelNmae: "빵빵이의 일상 ",
    sumbnail:"https://i.ytimg.com/vi/pHGfBQggFlQ/hq720.jpg?sqp=-oaymwEnCNAFEJQDSFryq4qpAxkIARUAAIhCGAHYAQHiAQoIGBACGAY4AUAB&rs=AOn4CLBAdS1mA3RtmazmntdllHVkC8AmRw",
    views: "8.3만",
  }]

  return (
    <>
      {/* <Head type ={10}></Head>// */}

      {/* <Head>
        <h2>무엇을 도와드릴까요?</h2>
      </Head> */}

      <Videos></Videos>
    </>
  )
}

export default App
