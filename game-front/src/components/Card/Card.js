import React, {useState} from 'react';
import './Card.css'

export const Card = ({card}) => {
    const [clicked, setClicked] = useState(false);

    return (
        <div className="artboard">
            <div className={`card ${clicked ? "clicked" : ""}`} onClick={() => setClicked(!clicked)}>

                <div className="card__side card__side--back">
                    <div className="card__cover" style={{backgroundColor:card.type.color}}>
                        <h4 className="card__heading">
                            <span className="card__heading-span">{card.type.title}</span>
                        </h4>
                    </div>
                    <div className="card__details">
                        <p>{card.description}</p>
                        <p className="amount">{card.amount}</p>
                    </div>
                </div>

                <div className="card__side card__side--front" style={{backgroundColor:card.type.color}}>
                    <div className="card__theme">
                        <div className="card__theme-box">
                            <p className="card__subject">{card.role}</p>
                            <p className="card__title">{card.type.title}</p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )
}




