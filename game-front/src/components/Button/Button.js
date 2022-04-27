import React, {useState} from "react";
import './Button.css'

export const Button = ({handleClick}) => {
    return (
        <div>
            <button className="btn" onClick={handleClick}>More</button>
        </div>
    );
}

