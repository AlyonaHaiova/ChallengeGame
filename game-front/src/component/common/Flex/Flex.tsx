import { FC } from "react";
import { IFlexProps } from "./Flex.types";
import FlexWrapper from "./styled/FlexWrapper";

const Flex: FC<IFlexProps> = (props) => {
    return (
        <FlexWrapper {...props}>
            {props.children}
        </FlexWrapper>
    );
}

export default Flex;
