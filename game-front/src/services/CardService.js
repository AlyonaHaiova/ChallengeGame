import {Roles} from "../components/Roles";

let male = true;

export const getCard = async () => {
    return {
        description: "Kiss",
        type: {
            title: "light",
            color: "pink",
        },
        role: Roles.Male,
        time: "1m",
    }
    male = !male;
    // const response = await fetch("");
    // const data = await response.json();
}

