import React from 'react';

export const Button = props=> {
    const handleClick = () => {
        props.handleClick();
    }

    return (
        <button className={"button" + props.class} onClick={handleClick}>
            {props.title}
        </button>
    )
}