import React, {useEffect, useState} from 'react';
import {Card} from "../Card/Card"
import {getCard} from "../../services/CardService";
import {Button} from "../Button/Button";
import {Loading} from "../Loading/Loading";
import '../Button/Button.css';
import './Page.css';


export const Page = () => {
    const [card, setCard] = useState(null);
    const fetchCard = async () => {
        setCard(null);
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
            <div className="card-container">
                {
                    card == null ? <Loading /> : <Card card={card} isClicked={false} />
                }
            </div>
            <Button handleClick={clickMore}/>
        </div>
    )
}