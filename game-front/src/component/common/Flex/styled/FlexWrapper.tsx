import styled, { css } from "styled-components";
import Device, { getMinWidthMedia } from "../../../../meta/device";
import { IFlexWrapperProps } from "./FlexWrapper.types";

const FlexWrapper = styled.div<IFlexWrapperProps>`
    display: flex;

    @media only screen and (${getMinWidthMedia(Device.small)}) {
        flex-direction: ${props => props.direction};
        justify-content: ${props => props.alignment};
    }

    ${props => props.changeOn != null && css`
        @media only screen and (${getMinWidthMedia(props.changeOn)}) {
            flex-direction: ${props.newDirection ?? props.direction};
            justify-content: ${props.newAlignment ?? props.alignment};
        }
    `}
`;

export default FlexWrapper;
