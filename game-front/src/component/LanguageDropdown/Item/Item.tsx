import { FC } from "react";
import { IItemProps } from "./Item.types";
import "./Item.scss";

const Item: FC<IItemProps> = ({label, imageSource}) => {
    return (
        <div className="Item s-hflex">
            <img src={imageSource} alt={label} />
            <span className="label s-vflex-center">{label}</span>
        </div>
    );
}

export default Item;
