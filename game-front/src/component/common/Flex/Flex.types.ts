import { ReactNode } from "react";
import Device from "../../../meta/device";
import FlexAlignment from "../../../meta/flex.alignment";
import FlexDirection from "../../../meta/flex.direction";

export interface IFlexProps {
    alignment: FlexAlignment,
    direction: FlexDirection,
    children: ReactNode,
    newDirection?: FlexDirection,
    newAlignment?: FlexAlignment,
    changeOn?: Device
}
