export const getCard = async (lastRole = "FEMALE") => {
    const response = await fetch(`http://192.168.0.128:8080/api/games/1/cards/random?role=${getRole(lastRole)}`);
    const data = await response.json();
    console.log(data);
    return data;
}

const getRole = lastRole => {
    return lastRole === "MALE" ? "FEMALE" : "MALE"
}




