import React from "react";
import "./Loading.css";

export const Loading = () => {
    return (
        <div className="loader-container">
            <div className="bar-loader">
                <div></div>
                <div></div>
                <div></div>
            </div>
        </div>
    );
}