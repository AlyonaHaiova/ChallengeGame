import { FC } from "react";
import "./Trigger.scss";
import { ITriggerProps } from "./Trigger.types";

const Trigger: FC<ITriggerProps> = ({imageSource}) => {
    return (
        <div className="Trigger s-hflex">
            <img src={imageSource} alt={imageSource} />
        </div>
    );
}

export default Trigger;