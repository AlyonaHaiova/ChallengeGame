import React, {useEffect, useState} from 'react';
import {Card} from "../components/Card"
import {Button} from "./Button";
import {getCard} from "../services/CardService";
import {Roles} from "./Roles";


export const Page = () => {
    const [card, setCard] = useState(null);
    const fetchCard = async () => {
        const newCard = await getCard();
        setCard(newCard);
    }
    useEffect(() => {
        fetchCard();
    }, []);
    const clickMore = () => {
        fetchCard();
    }
    return (
        <div id="page">
            {
                card == null ? (null) : <Card {...card} />
            }
            <Button class={"more-button"} title={"More"} handleClick={clickMore}/>
        </div>
    )
}