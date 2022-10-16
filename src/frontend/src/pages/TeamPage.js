import { React, useEffect, useState } from 'react';
import { MatchDetailCard } from '../components/MatchDetailCard';
import { MatchSmallCard } from '../components/MatchSmallCard';

export const TeamPage = () => {

    const[team,setTeam] = useState({});

useEffect(
    () => {
        const fetchMatches = async () => {
            const response = await fetch("https://gorest.co.in/public/v2/users/13");
            const data = await response.json();
            //console.log(data);
            setTeam(data);
        };
        fetchMatches();
    }, []
);


  return (
    <div className="TeamPage">
      <h1>Team Name</h1>
      <h2>{team.name}</h2>
      <MatchDetailCard/>
      <MatchSmallCard/>
      <MatchSmallCard/>
      <MatchSmallCard/>

    </div>
  );
}