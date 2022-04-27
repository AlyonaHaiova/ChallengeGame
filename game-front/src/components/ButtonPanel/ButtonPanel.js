import React from "react";
import {getCard, refreshCard, getPenaltyCard} from "../../services/CardService";
import './ButtonPanel.css'

export const ButtonPanel = ({
    currentRole = "FEMALE",
    onCompleted = () => {},
    onRefresh = () => {},
    onPenalty = () => {}
}) => {
    const completed = async event => {
        event.stopPropagation();
        const card = await getCard(currentRole);
        onCompleted(card);
    }

    const refresh = async event => {
        event.stopPropagation();
        const card = await refreshCard(currentRole);
        onRefresh(card);
    }

    const penalty = async event => {
        event.stopPropagation();
        const card = await getPenaltyCard(currentRole);
        onPenalty(card);
    }

    return (
        <div className="panel">
            <a href="#" className="icon-btn green" onClick={completed}><i className="large material-icons">check</i></a>
            <a href="#" className="icon-btn yellow" onClick={refresh}><i className="large material-icons">refresh</i></a>
            <a href="#" className="icon-btn red" onClick={penalty}><i className="large material-icons">clear</i></a>
        </div>
    );
}