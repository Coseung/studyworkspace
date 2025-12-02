import React from 'react'
import { HomeContainer, Title } from './Home.styled'
import { useTodos } from '../context/TodoContext'
import { CATEGORY_NAMES, CATEGORYS } from '../routes/routePaths';

const Home = () => {
  const {getState} =useTodos();
  const state = getState();

  const categories =[
    {name: CATEGORY_NAMES[CATEGORYS.WORK], value:CATEGORYS.WORK, count: byCategory.work},
    {name: CATEGORY_NAMES[CATEGORYS.STUDY], value:CATEGORYS.STUDY, count: byCategory.study},
    {name: CATEGORY_NAMES[CATEGORYS.HEALTH], value:CATEGORYS.HEALTH, count: byCategory.health},
    
  ]
  return (
    <HomeContainer>
        <Title>Dashboard</Title>

        <StateArea>
          <StateCard>
            <StateNumber>{state.total}</StateNumber>

          </StateCard>
        </StateArea>
        <StateArea>
          <StateCard>
            <StateNumber>{state.pending}</StateNumber>
            
          </StateCard>
        </StateArea>
        <StateArea>
          <StateCard>
            <StateNumber>{state.completed}</StateNumber>
          </StateCard>
        </StateArea>

        <CategoryArea>
          <AreaTitle>
          <CategoryList>
            {categories.map(category =>(
              
            ))}
          </CategoryList>
          </AreaTitle>
        </CategoryArea>
    </HomeContainer>
  )
}

export default Home