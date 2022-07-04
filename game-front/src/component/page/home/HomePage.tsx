import { FC } from "react";
import Device from "../../../meta/device";
import FlexAlignment from "../../../meta/flex.alignment";
import FlexDirection from "../../../meta/flex.direction";
import Flex from "../../common/Flex";

const HomePage: FC = () => {
    return (
        <Flex
            alignment={FlexAlignment.start}
            direction={FlexDirection.column}
            newDirection={FlexDirection.row}
            newAlignment={FlexAlignment.end}
            changeOn={Device.medium}
        >
            <div>First item</div>
            <div>Second item</div>
        </Flex>
    );
}

export default HomePage;
