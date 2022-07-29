import {FC} from "react";
import {IInput} from "./Input.types";
import './Input.css';

const Input: FC<IInput> = ({
    name= "",
    placeholder = "",
    ...rest
}) => {
    return (
        <div>
            <input className={"input-text"} id={name} placeholder={placeholder} {...rest}></input>
        </div>
    );
}

export default Input;
