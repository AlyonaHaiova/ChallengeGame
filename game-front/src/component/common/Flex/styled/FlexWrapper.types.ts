import Device from "../../../../meta/device";
import FlexAlignment from "../../../../meta/flex.alignment";
import FlexDirection from "../../../../meta/flex.direction";

export interface IFlexWrapperProps {
    alignment: FlexAlignment,
    direction: FlexDirection,
    newDirection?: FlexDirection,
    newAlignment?: FlexAlignment,
    changeOn?: Device
}
