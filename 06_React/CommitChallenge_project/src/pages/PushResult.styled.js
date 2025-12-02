import styled from "styled-components";

export const Container = styled.div`
    max-width: 600px;
    margin: 40px auto;
    padding: 20px;
    text-align: center;
`

export const Title = styled.h1`
    font-size: 2.5rem;
    color: #333;
    margin-bottom: 30px;
`

export const SearchBox = styled.div`
    display: flex;
    gap: 10px;
    justify-content: center;
    margin-bottom: 30px;
`

export const Input = styled.input`
    padding: 12px;
    font-size: 16px;
    border: 2px solid #ddd;
    border-radius: 8px;
    width: 200px;
    outline: none;
    transition: border-color 0.2s;

    &:focus { 
        border-color: #5833ff; 
    }
`

export const Button = styled.button`
    padding: 12px 24px;
    background-color: #5833ff;
    color: white;
    border: none;
    border-radius: 8px;
    font-size: 16px;
    cursor: pointer;
    transition: transform 0.1s, background-color 0.2s;

    &:disabled { 
        background-color: #ccc; 
        cursor: not-allowed;
    }

    &:hover:not(:disabled) { 
        transform: scale(0.98); 
        background-color: #4e2ce0;
    }
`

export const StatusMessage = styled.h2`
    font-size: 1.2rem;
    margin-bottom: 20px;
    color: #444;
    height: 30px; 
`

export const List = styled.ul`
    list-style: none;
    padding: 0;
    text-align: left;
`

export const Item = styled.li`
    background: #fff;
    border: 1px solid #eee;
    padding: 20px;
    margin-bottom: 15px;
    border-radius: 12px;
    box-shadow: 0 2px 8px rgba(0,0,0,0.05);
`

export const Time = styled.div`
    font-weight: bold;
    color: #5833ff;
    margin-bottom: 5px;
`

export const RepoName = styled.div`
    font-size: 0.9rem;
    color: #666;
    margin-bottom: 10px;
`

export const CommitList = styled.ul`
    list-style: none;
    padding: 0;
    background: #f9f9f9;
    padding: 10px;
    border-radius: 6px;
    display: block; 
`

export const CommitItem = styled.li`
    font-size: 0.9rem;
    color: #333;
    margin-bottom: 4px;
`