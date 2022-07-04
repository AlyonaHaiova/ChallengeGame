enum Device {
    small,
    medium,
    large,
    extraLarge
}

export const getMinWidthPx = (device: Device): number => {
    switch (device) {
        case Device.small:
            return 0;
        case Device.medium:
            return 601;
        case Device.large:
            return 993;
        case Device.extraLarge:
            return 1201;
    }
}

export const getMinWidthMedia = (device: Device): string => {
    return `min-width: ${getMinWidthPx(device)}px`;
}

export default Device;
