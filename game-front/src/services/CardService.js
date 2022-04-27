import {BASE_URL} from "../meta/AppConst";

export const getCard = async (lastRole = "FEMALE") => {
    const response = await fetch(`${BASE_URL}/api/games/1/cards/random?role=${getRole(lastRole)}&purpose=PLAYABLE`);
    const data = await response.json();
    return data;
}

export const refreshCard = async (lastRole = "FEMALE") => {
    const response = await fetch(`${BASE_URL}/api/games/1/cards/random?role=${lastRole}&purpose=PLAYABLE`);
    const data = await response.json();
    return data;
}

export const getPenaltyCard = async (lastRole = "FEMALE") => {
    const response = await fetch(`${BASE_URL}/api/games/1/cards/random?role=${lastRole}&purpose=PENALTY`);
    const data = await response.json();
    return data;
}

const getRole = lastRole => {
    return lastRole === "MALE" ? "FEMALE" : "MALE"
}




