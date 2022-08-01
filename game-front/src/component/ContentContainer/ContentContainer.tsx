import { FC } from "react";
import { IContentContainerProps } from "./ContentContainer.types";
import "./ContentContainer.css";

const ContentContainer: FC<IContentContainerProps> = ({children}) => {
    return (
        <div className="ContentContainer full-height">
            {children}
        </div>
    );
}

export default ContentContainer;
