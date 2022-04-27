import React, {useEffect, useState} from 'react';
import {Card} from "../Card/Card"
import {getCard} from "../../services/CardService";
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
    return (
        <div id="page">
            <div className="card-container">
                {
                    card == null ? <Loading /> : <Card initialCard={card} isClicked={false} />
                }
            </div>
        </div>
    )
}