import {FC} from "react";
import {IInput} from "./Input.types";
import './Input.css';

const Input: FC<IInput> = ({
    name = "",
    placeholder = "",
    className = "",
    ...rest
}) => {
    return (
        <div>
            <input className={`input-text ${className}`} id={name} placeholder={placeholder} {...rest}></input>
        </div>
    );
}

export default Input;
