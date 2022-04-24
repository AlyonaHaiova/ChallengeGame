import React from 'react';

export const Card = props => {
    return (
        <div className="card" style={{backgroundColor:props.type.color}}>
            <p>{props.description}</p>
            <p>{props.time}</p>
        </div>
    )
}




